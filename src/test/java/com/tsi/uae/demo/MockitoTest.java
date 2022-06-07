package com.tsi.uae.demo;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    private ProgramApplication pa;

    @Mock
    private ActorRepository actorRepository;


    @BeforeEach
    void setup(){
        pa = new ProgramApplication(actorRepository);
    }

    @Test
    public void getAllActors()
    {
        pa.getAllActors();
        verify(actorRepository).findAll();
    }

}
