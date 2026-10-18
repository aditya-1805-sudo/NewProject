package org.example;

import org.example.Configuration.ProjectConfig;
import org.example.Models.*;
import org.example.Services.CommentService;
import org.example.Services.DeliveryDetailsPrinter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.logging.Logger;

@SpringBootApplication
public class Main {
    private static Logger logger=Logger.getLogger(Main.class.getName());
    public static void main(String []args) {

        var context =new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot p=context.getBean(Parrot.class);
        System.out.println(p.getName());
        String s=context.getBean(String.class);
        int i=context.getBean(Integer.class);
        System.out.println(s+":"+i);
        Rabbit r=context.getBean(Rabbit.class);
        System.out.println(r.getName());
        Rabbit rab=new Rabbit();
        rab.setName("Imu");
        Supplier <Rabbit> rabbitSupplier=()-> rab;
        context.registerBean("rabbit1", Rabbit.class,rabbitSupplier,bc ->bc.setPrimary(true));
        System.out.println(context.getBean("rabbit1",Rabbit.class).getName());
        System.out.println(context.getBean(Person.class));
        System.out.println(context.getBean(Person.class).getParrot());
        p.setName("Shi");
        System.out.println(context.getBean(Person.class).getParrot());
        System.out.println(context.getBean(Person.class).getRabbit());
        Trainer t=context.getBean(Trainer.class);
        t.setName("Ash");
        t.getRabbit().setName("Ame");
        System.out.println("Trainer:"+context.getBean(Trainer.class).getName());
        System.out.println(context.getBean(Trainer.class).getRabbit());
        Person p1=context.getBean("person1", Person.class);
        System.out.println(p1.getParrot());
        ArrayList <String> list=new ArrayList<>();
        list.add("asvs");
        list.add("sss");
        DeliveryDetailsPrinter printer=context.getBean(DeliveryDetailsPrinter.class);
        printer.print(list);
        var comments=new Comments();
        comments.setAuthor("Aditya");
        comments.setText("Great");
        var commentsService=context.getBean(CommentService.class);
        commentsService.publish(comments);
        String value=commentsService.publishComment(comments);
        commentsService.editComment(comments);
        commentsService.deleteComment(comments);
        var plant1=context.getBean(Plant.class);
        var plant2=context.getBean(Plant.class);
        if(plant1!=plant2){
            System.out.println("Different Instances are being created");
        }
        logger.info(value);
    }
}
