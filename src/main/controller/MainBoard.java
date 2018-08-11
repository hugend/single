package main.controller;

import java.util.ArrayList;

import free.dto.FreeDTO;
import free.service.FreeService;
import free.service.FreeServiceImpl;
import local.dto.LeDTO;
import local.service.LocalService;
import local.service.LocalServiceImpl;
import mate.dto.MateDTO;
import mate.service.MateService;
import mate.service.MateServiceImpl;
import point.dto.PointDTO;
import point.service.PointService;
import point.service.PointServiceImpl;
import vs.dto.VsDTO;
import vs.service.VsService;
import vs.service.VsServiceImpl;

public class MainBoard {
	public ArrayList<LeDTO> leList(){
		LocalService service = new LocalServiceImpl();
		ArrayList<LeDTO> eventlist = service.geteventlist();
		return eventlist;
	}
	public ArrayList<FreeDTO> FreeList(){
		FreeService service = new FreeServiceImpl();
		ArrayList<FreeDTO> freelist = service.getPostList();
		// System.out.println(freelist.get(0).getFr_ctg());
		return freelist;
	}
	
	public ArrayList<MateDTO> MateList(){
		MateService service = new MateServiceImpl();
		ArrayList<MateDTO> matelist = service.group();
		return matelist;
	}
	
	public ArrayList<VsDTO> VsList(){
		VsService service = new VsServiceImpl();
		ArrayList<VsDTO> vslist = service.read();
		return vslist;
	}
	public ArrayList<PointDTO> PointList(){
		PointService service = new PointServiceImpl();
		ArrayList<PointDTO> pointlist = service.po_list();
		return pointlist;
	}
}
