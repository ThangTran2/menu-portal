package com.thangtm.menuportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thangtm.menuportal.entity.Menu;
import com.thangtm.menuportal.service.MenuService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/menus"})
public class MenuController {
	@Autowired
	private MenuService menuService;
	
	@PostMapping
	public Menu Create(@RequestBody Menu menu) {
		return menuService.create(menu);
	}
	
	@GetMapping(path = {"/{id}"})
	public Menu findOne(@PathVariable("id") int menu_seq ) {
		return menuService.findByMenuSeq(menu_seq);
	}
	
	@PatchMapping(path = {"/{id}"})
    public Menu update(@PathVariable("id") int menu_seq, @RequestBody Menu menu){
        menu.setMenuSeq(menu_seq);
        Menu menuOld = menuService.findByMenuSeq(menu_seq);
        menuOld = menu;
        return menuService.update(menuOld);
    }

    @DeleteMapping(path ={"/{id}"})
    public Menu delete(@PathVariable("id") int menu_seq) {
        return menuService.delete(menu_seq);
    }

    @GetMapping
    public List<Menu> findAll(){
        return menuService.findAll();
    }
}
