package com.tsi.uae.demo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    private MicroserviceApplication microserviceApplication;

    @Mock
    private ActorRepository actorRepository;


    @BeforeEach
    void setup(){
        microserviceApplication = new MicroserviceApplication(actorRepository);
    }

    @Test
    public void canGetAllActors()
    {
        microserviceApplication.getAllActors();
        verify(actorRepository).findAll();
    }
    @Test
    public void canGetActorsById()
    {

        Actor actor = new Actor("TEST", "TESTING");
        Mockito.when(microserviceApplication.getActorId(1)).thenReturn(Optional.of(actor));
        Optional<Actor> a = microserviceApplication.getActorId(1);

        Assertions.assertEquals("TEST",a.get().getFirst_name());
        Assertions.assertEquals("TESTING",a.get().getLast_name());
    }
    @Test
    public void canAddActor()
    {
        microserviceApplication.addActor("alex","ben");
        ArgumentCaptor<Actor> actorArgumentCaptor
                 = ArgumentCaptor.forClass(Actor.class);

        verify(actorRepository).save(actorArgumentCaptor.capture());
        Actor a = actorArgumentCaptor.getValue();
        Assertions.assertEquals(a.getFirst_name(),"alex","Incorrect First Name");
        Assertions.assertEquals(a.getLast_name(),"ben","Incorrect Last Name");
    }
    @Test
    public void canUpdateActor()
    {
        Actor actor = new Actor("TEST", "TESTING");
        Mockito.when(microserviceApplication.getActorId(1)).thenReturn(Optional.of(actor));
        microserviceApplication.updateActorById(1,"TESTING","TEST");
        Actor a = microserviceApplication.getActorId(1).orElseThrow();
        Assertions.assertEquals(a.getFirst_name(),"TESTING","Incorrect First Name");
        Assertions.assertEquals(a.getLast_name(),"TEST","Incorrect Last Name");

    }

    @Test
    //@Disabled
    public void canDeleteActor()
    {
        Boolean de = Boolean.FALSE;
        Actor actor = new Actor("TEST", "TESTING");
        microserviceApplication.addActor(actor.getFirst_name(),actor.getLast_name());
        Mockito.when(microserviceApplication.removeActorById(1)).thenReturn(de);
        //System.out.println(programApplication.getActorId(1).orElseThrow().getFirst_name());
        //programApplication.removeActorById(1);
        //verify(actorRepository).existsById(1);



        //Assertions.assertTrue(de);
    }
}
