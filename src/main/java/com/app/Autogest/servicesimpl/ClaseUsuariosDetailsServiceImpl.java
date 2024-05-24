/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.Autogest.servicesimpl;

import com.app.Autogest.controller.dto.AuthLoginRequest;
import com.app.Autogest.controller.dto.AuthResponse;
import com.app.Autogest.dao.IClaseUsuariosDao;
import com.app.Autogest.entity.Clase_Roles;
import com.app.Autogest.entity.Clase_Usuarios;
import com.app.Autogest.entity.RoleEnum;
import com.app.Autogest.util.JwtUtils;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author CLAUDIO CRUZADO
 */
@Service
public class ClaseUsuariosDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private IClaseUsuariosDao claseUsuarioDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Clase_Usuarios clase_Usuarios = claseUsuarioDao.findUsuarioByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe"));

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        // Obtener el rol del usuario
        Clase_Roles rol = clase_Usuarios.getIdRolesFK();
        authorityList.add(new SimpleGrantedAuthority("ROLE_" + rol.getRol()));

        rol.getPermissionList().forEach(permission -> authorityList.add(new SimpleGrantedAuthority(permission.getName())));

        return new User(clase_Usuarios.getUsername(),
                clase_Usuarios.getPassword(),
                clase_Usuarios.isEnabled(),
                clase_Usuarios.isAccountNoExpired(),
                clase_Usuarios.isCredentialNoExpired(),
                clase_Usuarios.isAccountNoLocked(),
                authorityList
        );
    }

    public AuthResponse loginUser(AuthLoginRequest authLoginRequest) {
        String username = authLoginRequest.username();
        String password = authLoginRequest.password();

        Authentication authentication = this.authenticate(username, password);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = jwtUtils.createToken(authentication);

        // Assuming that you have a method to get the user role from the authentication or username
        UserDetails userDetails = loadUserByUsername(username);
        String role = userDetails.getAuthorities().stream()
                .filter(grantedAuthority -> grantedAuthority.getAuthority().startsWith("ROLE_"))
                .map(grantedAuthority -> grantedAuthority.getAuthority().substring(5))
                .findFirst()
                .orElse("USER"); // Default role if none found

        AuthResponse authResponse = new AuthResponse(username, "User Logged successfully", accessToken, role, true);
        return authResponse;
    }

    public Authentication authenticate(String username, String password) {
        UserDetails userDetails = this.loadUserByUsername(username);

        if (userDetails == null) {
            throw new BadCredentialsException("Invalid username or password");
        }

        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        return new UsernamePasswordAuthenticationToken(username, userDetails.getPassword(), userDetails.getAuthorities());
    }

}
