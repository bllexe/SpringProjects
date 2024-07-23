package org.tigris.docker.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tigris.docker.entity.Visitor;
import org.tigris.docker.repository.VisitorRepository;

@RestController
public class VisitorController {

    private  final VisitorRepository visitorRepository;

    public VisitorController(VisitorRepository visitorRepository) {
        this.visitorRepository = visitorRepository;
    }

    @RequestMapping("/")
    public String index(HttpServletRequest request){
        String ip = request.getRemoteAddr();
        Visitor visitor = visitorRepository.findByIp(ip);
        if(visitor==null){
           visitor=new Visitor();
           visitor.setIp(ip);
           visitor.setTimes(1);
        }else{
            visitor.setTimes(visitor.getTimes()+1);
        }
        visitorRepository.save(visitor);
        return visitor.getIp() + " / " + visitor.getTimes();

    }
}
