package com.ttknp.springbootenablehttpscrudmysql.control;

import com.ttknp.springbootenablehttpscrudmysql.entity.Actor;
import com.ttknp.springbootenablehttpscrudmysql.service.ActorService;
import com.ttknpdev.constant.CommonStatus;
import com.ttknpdev.entity.ResponseObject;
import com.ttknpdev.logging.MyLog4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EndpointController {
    private MyLog4j log4j;
    private ActorService actorService;

    @Autowired
    public EndpointController(ActorService actorService) {
        log4j=new MyLog4j(EndpointController.class);
        this.actorService = actorService;
    }

    @GetMapping(value = "/server")
    private ResponseEntity<ResponseObject> server() {
        log4j.log.warn("{}","req api/server");
        return ResponseEntity.ok(
                ResponseObject
                        .<String>builder()
                        .status((Short) CommonStatus.OK[0])
                        .info((String) CommonStatus.OK[1])
                        .data("Running")
                        .build()
        );
    }


    @GetMapping(value = "/actor/")
    private ResponseEntity<ResponseObject> getAllActors() {
        log4j.log.warn("{}","req api/actor/reads");
        return ResponseEntity.ok(
                ResponseObject
                        .<Iterable<Actor>>builder()
                        .status((Short) CommonStatus.OK[0])
                        .info((String) CommonStatus.OK[1])
                        .data(actorService.getAllActors())
                        .build()
        );
    }

    @GetMapping(value = "/actor")
    private ResponseEntity<ResponseObject> getActor(@RequestParam("aid") Long aid) {
        log4j.log.warn("{}","req api/actor?aid="+aid);
        return ResponseEntity.ok(
                ResponseObject
                        .<Optional<Actor>>builder()
                        .status((Short) CommonStatus.OK[0])
                        .info((String) CommonStatus.OK[1])
                        .data(actorService.getActor(aid))
                        .build()
        );
    }

    @PostMapping(value = "/actor")
    private ResponseEntity<ResponseObject> addActor(@RequestBody Actor actor) {
        log4j.log.warn("{}","req (POST) api/actor");
        return ResponseEntity.ok(
                ResponseObject
                        .<Boolean>builder()
                        .status((Short) CommonStatus.OK[0])
                        .info((String) CommonStatus.OK[1])
                        .data(actorService.addActor(actor))
                        .build()
        );
    }

    @PutMapping(value = "/actor")
    private ResponseEntity<ResponseObject> editActor(@RequestBody Actor actor,@RequestParam Long aid) {
        log4j.log.warn("{}","req (PUT) api/actor");
        return ResponseEntity.ok(
                ResponseObject
                        .<Boolean>builder()
                        .status((Short) CommonStatus.OK[0])
                        .info((String) CommonStatus.OK[1])
                        .data(actorService.editActor(actor,aid))
                        .build()
        );
    }

    @DeleteMapping(value = "/actor")
    private ResponseEntity<ResponseObject> removeActor(@RequestParam Long aid) {
        log4j.log.warn("{}","req (DELETE) api/actor");
        return ResponseEntity.ok(
                ResponseObject
                        .<Boolean>builder()
                        .status((Short) CommonStatus.OK[0])
                        .info((String) CommonStatus.OK[1])
                        .data(actorService.removeActor(aid))
                        .build()
        );
    }
}
