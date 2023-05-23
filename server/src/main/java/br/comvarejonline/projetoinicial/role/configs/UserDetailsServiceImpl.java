package br.comvarejonline.projetoinicial.role.configs;

import br.comvarejonline.projetoinicial.user.model.UserModel;
import br.comvarejonline.projetoinicial.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {


  private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel userModel = userRepository.findbyUsername(username)
                .orElseThrow( () -> new UsernameNotFoundException(" username Not found with username " + username));

        return new User(userModel.getUsername(), userModel.getPassword(), true, true, true,true, userModel.getAuthorities());    }
}
