package tacos.tacos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Incheol Jung
 */
@RestController
@RequestMapping("taco")
public class TacoController {
    @Autowired
    TacoRepository tacoRepository;

    @GetMapping
    public String test(){
        Taco taco = new Taco();
        taco.setName("incheol");
        tacoRepository.save(taco);

        return "test";
    }
}
