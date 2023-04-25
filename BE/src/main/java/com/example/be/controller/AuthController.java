package com.example.be.controller;

import com.example.be.dto.request.SignInForm;
import com.example.be.dto.request.SignUpForm;
import com.example.be.dto.response.JwtResponse;
import com.example.be.dto.response.ResponseMessage;
import com.example.be.model.Role;
import com.example.be.model.RoleName;
import com.example.be.model.User;
import com.example.be.security.jwt.JWTProvider;
import com.example.be.security.userPrinciple.UserPrinciple;
import com.example.be.service.IRoleService;
import com.example.be.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RequestMapping("/api/auth")
@RestController
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTProvider jwtProvider;
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IRoleService iRoleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/signup")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpForm signUpForm, BindingResult bindingResult) {
        new SignUpForm().validate(iUserService.findAll(),signUpForm,bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.BAD_REQUEST);
        }
        if (iUserService.existsByUserName(signUpForm.getUsername())) {
            return new ResponseEntity<>(new ResponseMessage("Tên đăng " + signUpForm.getUsername() + " nhập đã được sử dụng, vui lòng chọn tên khác"), HttpStatus.BAD_REQUEST);
        }
        if (iUserService.existsByEmail(signUpForm.getEmail())) {
            return new ResponseEntity<>(new ResponseMessage("Email " + signUpForm.getEmail() + " đã được sử dụng"), HttpStatus.BAD_REQUEST);
        }
        User user = new User( signUpForm.getUsername(),signUpForm.getName(), passwordEncoder.encode(signUpForm.getPassword()), signUpForm.getEmail());
        Set<String> strRoles = signUpForm.getRoles();
        Set<Role> roles = new HashSet<>();
        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    Role roleAdmin = iRoleService.findByName(RoleName.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Role not found 1"));
                    roles.add(roleAdmin);
                    break;
                case "employee":
                    Role roleEmployee = iRoleService.findByName(RoleName.ROLE_EMPLOYEE).orElseThrow(() -> new RuntimeException("Role not found 2"));
                    roles.add(roleEmployee);
                    break;
                default:
                    Role roleCustomer = iRoleService.findByName(RoleName.ROLE_CUSTOMER).orElseThrow(() -> new RuntimeException("Role not found 3"));
                    roles.add(roleCustomer);
            }
        });
        user.setRoles(roles);
        iUserService.save(user);
        return new ResponseEntity<>(new ResponseMessage("Đăng kí thành công"), HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody SignInForm signInForm , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(),HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInForm.getUsername(), signInForm.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.createToken(authentication);
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        return ResponseEntity.ok(new JwtResponse(token, userPrinciple.getName(), userPrinciple.getId(),  userPrinciple.getEmail()
                , userPrinciple.getAuthorities()));
    }
    @GetMapping("/profile/{id}")
    public ResponseEntity<?> profile(@PathVariable("id") int id) {
        return new ResponseEntity<>(iUserService.findById(id),HttpStatus.ACCEPTED);
    }
}
