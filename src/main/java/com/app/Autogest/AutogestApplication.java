package com.app.Autogest;

import com.app.Autogest.entity.Clase_Roles;
import com.app.Autogest.entity.PermissionEntity;
import com.app.Autogest.entity.RoleEnum;
import java.util.List;
import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import com.app.Autogest.dao.IClaseRolesDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AutogestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutogestApplication.class, args);
	}
        
//        @Bean
//        CommandLineRunner init(IClaseRolesDao iClaseRolesDao){
//            return args ->{
//                /*Crear permisos*/
//                PermissionEntity masterPermission = PermissionEntity.builder()
//                .name("MASTER")
//                .build();
//                
//                PermissionEntity avanzadoPermission = PermissionEntity.builder()
//                .name("AVANZADO")
//                .build();
//                
//                PermissionEntity intermedioPermission = PermissionEntity.builder()
//                .name("INTERMEDIO")
//                .build();
//                
//                PermissionEntity basicoPermission = PermissionEntity.builder()
//                .name("BASICO")
//                .build();
//                
//                PermissionEntity clientPermission = PermissionEntity.builder()
//                .name("CLIENTE")
//                .build();
//                
//                /*Crear Roles*/
//                Clase_Roles roleDeveloper = Clase_Roles.builder()
//                        .rol(RoleEnum.DEVELOPER)
//                        .permissionList(Set.of(masterPermission, avanzadoPermission,intermedioPermission, basicoPermission, clientPermission))
//                        .build();
//                Clase_Roles roleAdmin = Clase_Roles.builder()
//                        .rol(RoleEnum.ADMIN)
//                        .permissionList(Set.of(masterPermission, intermedioPermission, basicoPermission))
//                        .build();
//                Clase_Roles roleRecepcionista = Clase_Roles.builder()
//                        .rol(RoleEnum.TECNICO)
//                        .permissionList(Set.of(intermedioPermission))
//                        .build();
//                Clase_Roles roleTecnico = Clase_Roles.builder()
//                        .rol(RoleEnum.RECEPCIONISTA)
//                        .permissionList(Set.of(basicoPermission))
//                        .build();
//                Clase_Roles roleCliente = Clase_Roles.builder()
//                        .rol(RoleEnum.CLIENTE)
//                        .permissionList(Set.of(clientPermission))
//                        .build();
//               
//                iClaseRolesDao.saveAll(List.of(roleDeveloper, roleAdmin, roleRecepcionista, roleTecnico, roleCliente));
//            };
//        }

}


//public class Main {
//    public static void main(String[] args) {
//        String password = "1234";
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String hashedPassword = passwordEncoder.encode(password);
//
//        System.out.println("Contraseña original: " + password);
//        System.out.println("Contraseña encriptada: " + hashedPassword);
//    }
//}


                /*Crear Roles*/
//                Clase_Usuarios userClaudio = Clase_Usuarios.builder()
//                        .username("claudio")
//                        .password("1234")
//                        .isEnabled(true)
//                        .accountNoExpired(true)
//                        .accountNoLocked(true)
//                        .credentialNoExpired(true)
//                        .roles(Set.of(roleDeveloper))
//                        .build();
//                
//                Clase_Usuarios userPaul = Clase_Usuarios.builder()
//                        .username("paul")
//                        .password("1234")
//                        .isEnabled(true)
//                        .accountNoExpired(true)
//                        .accountNoLocked(true)
//                        .credentialNoExpired(true)
//                        .roles(Set.of(roleAdmin))
//                        .build();
//                
//                Clase_Usuarios userCruzado = Clase_Usuarios.builder()
//                        .username("cruzado")
//                        .password("1234")
//                        .isEnabled(true)
//                        .accountNoExpired(true)
//                        .accountNoLocked(true)
//                        .credentialNoExpired(true)
//                        .roles(Set.of(roleTecnico))
//                        .build();
//                
//                Clase_Usuarios userEsquivel = Clase_Usuarios.builder()
//                        .username("esquivel")
//                        .password("1234")
//                        .isEnabled(true)
//                        .accountNoExpired(true)
//                        .accountNoLocked(true)
//                        .credentialNoExpired(true)
//                        .roles(Set.of(roleRecepcionista))
//                        .build();
                
//                iClaseUsuariosDao.saveAll(List.of(userClaudio, userPaul, userCruzado, userEsquivel));