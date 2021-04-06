package com.example.demo.controller;

import com.example.demo.model.Topic;
import com.example.demo.repo.TopicRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {
    @Autowired
    private TopicRepo topicRepo;
@RequestMapping("/topics")
    public List<Topic> all_topics(){
    return topicRepo.getAllTopicList();
}
@RequestMapping("/topics/{id}")
    public Topic gerTopic(@PathVariable("id")String id){
    return topicRepo.getTopic(id);
}
@RequestMapping(method= RequestMethod.POST,value="/topics")
    public void addTopic(@RequestBody Topic topic){
    topicRepo.addTopic(topic);
}
    @RequestMapping(method= RequestMethod.PUT,value="/topics{id}")
    public void updateTopic(@RequestBody Topic topic,@PathVariable("id")String id){
        topicRepo.updateTopic(topic,id);
    }
    @RequestMapping(method= RequestMethod.DELETE,value="/topics{id}")
    public void deleteTopic(@RequestBody Topic topic,@PathVariable("id")String id){
        topicRepo.deleteTopic(id);
    }

}

