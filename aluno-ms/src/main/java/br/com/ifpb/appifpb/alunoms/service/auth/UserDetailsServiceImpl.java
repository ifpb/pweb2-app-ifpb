package br.com.ifpb.appifpb.alunoms.service.auth;

import br.com.ifpb.appifpb.alunoms.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository usuarioRepository) {
        this.userRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String matricula) throws UsernameNotFoundException {
        return userRepository.findById(matricula).orElseThrow( () -> new UsernameNotFoundException(matricula));
    }
}
