package com.example.mag.aktuelapi.service;

import com.example.mag.aktuelapi.dto.MarkDto;
import com.example.mag.aktuelapi.model.Mark;
import com.example.mag.aktuelapi.repository.MarkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarkService {


    private final MarkRepository markRepository;

    public MarkService(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    public Mark getMarkId(Long id) throws Exception {
        Optional<Mark> mark = markRepository.findById(id);
        if (mark.isPresent()) {
            return mark.get();
        } else {
            throw  new Exception("Id ye ait  bir mark bulunamadı");
        }
    }
    public List<Mark> findAll() {
        return markRepository.findAll();
    }

    public Mark create(MarkDto markDto) {
        Mark mark=new Mark();
        mark.setName(markDto.getName());
        markRepository.save(mark);
        return mark;
    }

}
