package com.tsi.uae.demo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
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

    private ProgramApplication programApplication;

    @Mock
    private ActorRepository actorRepository;


    @BeforeEach
    void setup(){
        programApplication = new ProgramApplication(actorRepository);
    }

    @Test
    public void canGetAllActors()
    {
        programApplication.getAllActors();
        verify(actorRepository).findAll();
    }
    @Test
    public void canGetActorsById()
    {

        Actor actor = new Actor("TEST", "TESTING");
        Mockito.when(programApplication.getActorId(1)).thenReturn(Optional.of(actor));
        Optional<Actor> a = programApplication.getActorId(1);

        Assertions.assertEquals("TEST",a.get().getFirst_name());
        Assertions.assertEquals("TESTING",a.get().getLast_name());
    }
    @Test
    public void canAddActor()
    {
        programApplication.addActor("alex","ben");
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
        Mockito.when(programApplication.getActorId(1)).thenReturn(Optional.of(actor));
        programApplication.updateActorById(1,"TESTING","TEST");
        Actor a = programApplication.getActorId(1).orElseThrow();
        Assertions.assertEquals(a.getFirst_name(),"TESTING","Incorrect First Name");
        Assertions.assertEquals(a.getLast_name(),"TEST","Incorrect Last Name");

    }

    @Test
    @Disabled
    public void canDeleteActor()
    {
        Actor actor = new Actor("TEST", "TESTING");
        //programApplication.addActor("TEST", "TESTING");
        Mockito.when(programApplication.getActorId(1)).thenReturn(Optional.of(actor));
        programApplication.removeActorById(1);
        ArgumentCaptor<Integer> actorArgumentCaptor
            = ArgumentCaptor.forClass(Integer.class);

        verify(actorRepository).deleteById(actorArgumentCaptor.capture());
        Assertions.assertEquals(actorArgumentCaptor.getValue(),1,"Delete test failed");
        //Assertions.assertTrue();
    }
}
