package br.com.ifpb.appifpb.alunoms.service;

import br.com.ifpb.appifpb.alunoms.controller.dto.UserDTO;
import br.com.ifpb.appifpb.alunoms.domain.auth.User;
import br.com.ifpb.appifpb.alunoms.repository.UserRepository;
import br.com.ifpb.appifpb.alunoms.service.exception.UserException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(UserDTO userDTO) throws UserException {
        User user = new User(userDTO.getMatricula(), userDTO.getSenha());
        try{
            user.setSenha(passwordEncoder.encode(user.getSenha()));
            this.userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new UserException("Login já cadastrado");
        }
    }

}
