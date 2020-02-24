package com.example.demod.service.freeboard;

import com.example.demod.model.Freeboard;
import com.example.demod.repository.FreeboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FreeboardWriteService {

    @Autowired
    private FreeboardRepository freeboardRepository;

    public void write(String title, String content, String account, String writer, String phoneNumber){
        Freeboard freeboard = Freeboard.builder()
                .title(title)
                .content(content)
                .account(account)
                .writer(writer)
                .phoneNumber(phoneNumber)
                .build();

        freeboardRepository.save(freeboard);

    }
}
