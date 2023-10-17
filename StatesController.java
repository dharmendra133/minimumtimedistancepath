package com.example.Main.Controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Main.Graph;
import com.example.Main.Entities.KeyValue;
import com.example.Main.Entities.ReqEntity;
import com.example.Main.Entities.States;
import com.example.Main.StatesServices.StatesService;


@RestController
public class StatesController {
	@Autowired
	StatesService stateservice;
	ReqEntity reqentity;
	Graph graph=new Graph();
	
	@PostMapping("/add")
	public void addstate(@RequestBody States states) {
		this.stateservice.addState(states);
	}
	
	@GetMapping("/state")
	public ResponseEntity<List<States>> getState(){
		List<States> list=this.stateservice.findAll();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		for(States st: list) {
			String s=st.getSrc();
			String d=st.getDest();
			char m=st.getMode();
			float p=st.getPrice();
			float t=st.getTimereq();
			graph.makeGraph(s, d, p, t, m);
		}
		System.out.println(graph.minTime(graph.stateMappingNumber.get("Delhi"), graph.stateMappingNumber.get("Katra")));
		return ResponseEntity.of(Optional.of(list));
		
	}
	
	@GetMapping("/cheapest")
	@ResponseBody
	public ResponseEntity<KeyValue> cheap(@RequestBody ReqEntity reqentity){
		List<States> list=this.stateservice.findAll();
		for(States st: list) {
			String s=st.getSrc();
			String d=st.getDest();
			char m=st.getMode();
			float p=st.getPrice();
			float t=st.getTimereq();
			graph.makeGraph(s, d, p, t, m);
		}
		
		KeyValue output=new KeyValue();
		String src1=reqentity.getSrc();
		String desc1=reqentity.getDest();
		System.out.println(src1+" "+desc1);
		if(graph.stateMappingNumber.get(src1) == null || graph.stateMappingNumber.get(desc1)==null) {
			output.setAns("No Route");
			return ResponseEntity.ok(output);
		}
		String ans=graph.minPrice(graph.stateMappingNumber.get(src1), graph.stateMappingNumber.get(desc1));
		output.setAns(ans);
		return ResponseEntity.ok(output);
		
	}
	
	
	
	
	@GetMapping("/fastest")
	@ResponseBody
	public String fast(@RequestBody ReqEntity reqentity){
		List<States> list=this.stateservice.findAll();
		for(States st: list) {
			String s=st.getSrc();
			String d=st.getDest();
			char m=st.getMode();
			float p=st.getPrice();
			float t=st.getTimereq();
			graph.makeGraph(s, d, p, t, m);
		}
		
//		KeyValue output=new KeyValue();
		String src1=reqentity.getSrc();
		String desc1=reqentity.getDest();
		System.out.println(src1+" "+desc1);
		if(graph.stateMappingNumber.get(src1) == null || graph.stateMappingNumber.get(desc1)==null) {
			
			return "No route";
		}
		String ans=graph.minTime(graph.stateMappingNumber.get(src1), graph.stateMappingNumber.get(desc1));
		
		return ans;
		
	}
	
	
	@GetMapping("/allroute")
	@ResponseBody
	public String allPaths(@RequestBody ReqEntity reqentity){
		List<States> list=this.stateservice.findAll();
		for(States st: list) {
			String s=st.getSrc();
			String d=st.getDest();
			char m=st.getMode();
			float p=st.getPrice();
			float t=st.getTimereq();
			graph.makeGraph(s, d, p, t, m);
		}
		
//		KeyValue output=new KeyValue();
		String src1=reqentity.getSrc();
		String desc1=reqentity.getDest();
		System.out.println(src1+" "+desc1);
		if(graph.stateMappingNumber.get(src1) == null || graph.stateMappingNumber.get(desc1)==null) {
			
			return "No route";
		}
		String ans=graph.allRoute(graph.stateMappingNumber.get(src1), graph.stateMappingNumber.get(desc1));
		
		return ans;
		
	}
	
	
	
	
	
	
}
