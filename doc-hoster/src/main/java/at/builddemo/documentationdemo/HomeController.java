package at.builddemo.documentationdemo;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String index() throws Exception {
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = pathMatchingResourcePatternResolver.getResources("classpath:/public/*");

        // very stupid demo-implementation
        String versions = Arrays.stream(resources)
                .map(it -> {
                    var name = it.getFilename();
                    return "<li><a href=\"./" + name + "/index.html\">" + name + "</a></li>";
                })
                .collect(Collectors.joining());

        return "<h1>Welcome to the docs!</h1>" +
                "<div>" +
                "Versions:" +
                versions +
                "</div>";
    }

}
