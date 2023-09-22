package com.example.sozinho.controller;


import com.example.sozinho.model.LoginModel;
import com.example.sozinho.model.sozinhoFakeModel;
import com.example.sozinho.service.SozinhoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.List;

@RestController
public class sozinhoController {
    private final SozinhoService sozinhoService;
    private static final Logger log = LoggerFactory.getLogger(sozinhoController.class);


    @Autowired
    public sozinhoController(SozinhoService sozinhoService) {
        this.sozinhoService = sozinhoService;
    }
@GetMapping("/")
    public String inicio(){
    return "Ola mundo";
    }
    public void conf(){

    }
    @GetMapping("/fakeapi")
    public List<sozinhoFakeModel> getAll(){
    List<sozinhoFakeModel> postagem = new ArrayList<>();
    postagem.add(new sozinhoFakeModel(1,"Julian", "31"));
    postagem.add(new sozinhoFakeModel(2,"Diego", "28"));
    postagem.add(new sozinhoFakeModel(3,"Selma", "45"));
    postagem.add(new sozinhoFakeModel(4,"Julio", "60"));
    return postagem;
    }


    @ApiOperation(value = "Listando todas as tarefas")
    @ApiResponses( value ={
            @ApiResponse(code = 200, message = "Tarefas listadas com sucesso"),
            @ApiResponse(code = 500, message = "Houve um erro ao listar as tarefas"),
            @ApiResponse(code = 404, message = "Sei lá")

    })
    @GetMapping("/api")
    @ResponseStatus(HttpStatus.OK)
    public List<LoginModel> getAllTasks() {
        log.info("Listando todas as tarefas cadastradas");
        return sozinhoService.listAllTasks();
    }
    //Buscar por id
    @ApiOperation(value = "Buscando uma tarefa pelo id")
    @ApiResponses( value ={
            @ApiResponse(code = 200, message = "Tarefa encontrada com sucesso"),
            @ApiResponse(code = 404, message = "N o foi encontrada nenhuma tarefa com esse id")

    })
    @GetMapping("/api/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<LoginModel> getTaskById(@PathVariable (value = "id") Long id) {
        log.info("Buscando tarefa com o id [{}]", id);
        return sozinhoService.findAppById(id);
    }
    //Inserir
    @ApiOperation(value = "Criando uma nova tarefa")
    @ApiResponses( value ={
            @ApiResponse(code = 201, message = "Tarefa criada com sucesso"),
            @ApiResponse(code = 500, message = "Houve um erro ao criar a tarefa, verifique as informa  es")

    })

    @PostMapping("/inserir")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginModel createTask(@RequestBody LoginModel loginModel) {
        log.info("Criando uma nova tarefa com as informa  es [{}]", loginModel);
        return sozinhoService.createApp(loginModel);
    }
//atualizar
@ApiOperation(value = "Atualizando uma tarefa")
@ApiResponses( value ={
        @ApiResponse(code = 200, message = "Tarefa atualizada com sucesso"),
        @ApiResponse(code = 404, message = "Nao foi possivel atualizar a tarefa - tarefa nao encontrada")

})
@PutMapping("/atualizar/{id}")
@ResponseStatus(HttpStatus.OK)
public ResponseEntity<LoginModel> updateTaskById(@PathVariable (value = "id") Long id, @RequestBody LoginModel loginModel) {
    log.info("Atualizando a tarefa com id [{}] as novas informa  es s o : [{}]",id, loginModel);

    return updateTaskById(id, loginModel);
}

//Deletar
    @ApiOperation(value = "Excluindo uma tarefa")
    @ApiResponses( value ={
            @ApiResponse(code = 204, message = "Tarefa excluida com sucesso"),
            @ApiResponse(code = 404, message = "Nao foi possivel excluir a tarefa - tarefa nao encontrada")

    })
    @DeleteMapping("/apagar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteTaskById(@PathVariable (value = "id") Long id) {
        log.info("Excluindo tarefas com o id [{}]", id);
        return sozinhoService.deleteAppById(id);
    }
}
