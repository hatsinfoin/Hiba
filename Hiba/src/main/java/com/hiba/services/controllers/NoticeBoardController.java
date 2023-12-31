package com.hiba.services.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hiba.services.model.NoticeBoardDetails;
import com.hiba.services.services.NoticeBoardService;

@RestController
@RequestMapping("/v1/noticeboard")
public class NoticeBoardController {

    private final NoticeBoardService noticeBoardService;

    public NoticeBoardController(NoticeBoardService noticeBoardService) {
        this.noticeBoardService = noticeBoardService;
    }

    @GetMapping("/getAllNotices")
    public ResponseEntity<List<NoticeBoardDetails>> getAllNotices(){
    		return ResponseEntity.ok(noticeBoardService.getAllNotices());
    }
    
    @PostMapping("/saveNoticeBoard")
    public ResponseEntity<NoticeBoardDetails> saveNoticeBoard(@RequestBody  NoticeBoardDetails noticeBoardDetails ){
    		return ResponseEntity.ok(noticeBoardService.saveNoticeBoard(noticeBoardDetails));
    }
    

}
