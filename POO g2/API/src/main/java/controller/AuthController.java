package com.POO.TRABALHO.API.controller;

import br.com.POO.TRABALHO.API.model.Usuario;
import br.com.POO.TRABALHO.API.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/auth/signup")
    public String signUp(@RequestBody Usuario usuario) {

        String senha = generateRandomPassword();


        String senhaCriptografada = passwordEncoder.encode(senha);


        usuario.setSenha(senhaCriptografada);
        
        usuarioService.save(usuario);

        return senha;
    }

    @PostMapping("/auth/signin")
    public String signIn(@RequestBody Usuario usuario) {


        return "JWT Token";
    }

    private String generateRandomPassword() {

        return "senhaAleatoria";
    }
}
