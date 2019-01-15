package com.thangtm.menuportal.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.hibernate.boot.spi.MetadataBuilderContributor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thangtm.menuportal.entity.Meta;
import com.thangtm.menuportal.service.MetaService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/metas"})
public class MetaController {
	@Autowired
	private MetaService metaService;
	
	@PostMapping
	public Meta Create(@RequestBody Meta meta) {
		return metaService.create(meta);
	}
	
	@Scheduled(initialDelay = 2000, fixedRate = 20000)
	public void CronJob() throws IOException{
		
		// create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();
		
		StringBuilder sbJson = new StringBuilder();
		
		//get data from url
		try {
			String url = "http://localhost:3000/data";
			
			URL objUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) objUrl.openConnection();
			
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			
			conn.setRequestMethod("GET");
			
			BufferedReader reader = new BufferedReader ( new InputStreamReader(conn.getInputStream()) );
			for (String line; (line = reader.readLine()) != null;) {
//			        System.out.println(line); 
			        sbJson.append(line.trim());
			}
			reader.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		// read json file data to String
//		byte[] jsonData = Files.readAllBytes(Paths.get("main_data_api.json"));

		System.out.println(sbJson.toString());

		// read JSON like DOM Parser
		JsonNode rootNode = objectMapper.readTree(sbJson.toString());
		
		//Access Data Note
//		JsonNode dataNodes = rootNode.path("data");
		//Move through data note
//		Iterator<JsonNode> elements = dataNodes.elements();
		Iterator<JsonNode> elements = rootNode.elements();

		Vector<Meta> listMeta = new Vector();
		
		while(elements.hasNext()) {
			Meta metaCopy = new Meta();
			//copy
			JsonNode data = elements.next();
			//System.out.println(data.asText());
			
			//check if a key exists
			if(data.has("MAIN.DATA.Seq")) 
			{
//				System.out.println("******** key ton tai  MAIN.DATA.Seq  **************");
				
//				String strTemp = data.get("MAIN.DATA.Seq").asText();
				//Long numTempLong = Long.valueOf( strTemp.substring(0, strTemp.length())  );
				//strTemp = strTemp.replaceAll("\"", " "); strTemp.trim();
				//System.out.println( " main data seq: " + numTempLong + " - num covert : " + strTemp );
				System.out.println(data.get("MAIN.DATA.Seq").asLong());
				
				//Set values MD_SEQ
				metaCopy.setMdSeq(data.get("MAIN.DATA.Seq").asLong());
				
				//Set values D_SEQ
//				strTemp = data.get("MAIN.DATA.CrawlStamp").asText();
//				int numTemp = Integer.parseInt(strTemp.substring(1, strTemp.length()-1));
				metaCopy.setdSeq((data.get("MAIN.DATA.CrawlStamp").asLong()));
				
				//Set values MD_PSEQ
				
				//Set values MD_DATE
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
			    Date date = new Date();
			    metaCopy.setMdDate(formatter.format(date).toString());
				
				//Set values S_SEQ
//			    strTemp = data.get("COMMON.SITE.Seq").asText();
//				numTemp = Integer.parseInt(strTemp.substring(0, strTemp.length()-1));
			    metaCopy.setsSeq((data.get("COMMON.SITE.Seq").asLong()));
			    
				//Set values MD_SITENAME
			    metaCopy.setMdSiteName(data.get("COMMON.SITE.Name").asText());
			    
				//Set values MD_MENUNAWE
			    metaCopy.setMdMenuName(data.get("MAIN.BOARD.Name").asText());
			    
				//Set values MD_TITLE
			    metaCopy.setMdTitle(data.get("MAIN.DATA.Title").asText());
			    
				//Set values MD_URL
			    metaCopy.setMdURL(data.get("MAIN.DATA.Link").asText());
			    
				//Set values MD_SAME_COUNT
			    
			    
				//Set values MD_ISSUE_YN
			}
			if(data.has("TWITTER.DATA.Seq")) 
			{
//				System.out.println("******** key ton tai  TWITTER.DATA.Seq  **************");
				//Set values MD_SEQ
				metaCopy.setMdSeq(data.get("TWITTER.DATA.Seq").asLong());
				
				//Set values D_SEQ
				metaCopy.setdSeq((data.get("TWITTER.DATA.CrawlStamp").asLong()));
				
				//Set values MD_PSEQ
				
				//Set values MD_DATE
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
			    Date date = new Date();
			    metaCopy.setMdDate(formatter.format(date).toString());
				
				//Set values S_SEQ
			    metaCopy.setsSeq((data.get("TWITTER.DATA.ID").asLong()));
			    
				//Set values MD_SITENAME
//			    metaCopy.setMdSiteName(data.get("COMMON.SITE.Name").asText());
			    
				//Set values MD_MENUNAWE
//			    metaCopy.setMdMenuName(data.get("MAIN.BOARD.Name").asText());
			    
				//Set values MD_TITLE
			    metaCopy.setMdTitle(data.get("TWITTER.DATA.WriterID").asText());
			    
				//Set values MD_URL
			    metaCopy.setMdURL(data.get("TWITTER.DATA.Link").asText());
			    
				//Set values MD_SAME_COUNT
			    
			    
				//Set values MD_ISSUE_YN
			}
			if(data.has("FACEBOOK.DATA.Seq")) 
			{
//				System.out.println("******** key ton tai  FACEBOOK.DATA.Seq  **************");
				//Set values MD_SEQ
				metaCopy.setMdSeq(data.get("FACEBOOK.DATA.Seq").asLong());
				
				//Set values D_SEQ
				metaCopy.setdSeq((data.get("FACEBOOK.DATA.CrawlStamp").asLong()));
				
				//Set values MD_PSEQ
				
				//Set values MD_DATE
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
			    Date date = new Date();
			    metaCopy.setMdDate(formatter.format(date).toString());
				
				//Set values S_SEQ
			    metaCopy.setsSeq((data.get("FACEBOOK.DATA.ID").asLong()));
			    
				//Set values MD_SITENAME
//			    metaCopy.setMdSiteName(data.get("COMMON.SITE.Name").asText());
			    
				//Set values MD_MENUNAWE
//			    metaCopy.setMdMenuName(data.get("MAIN.BOARD.Name").asText());
			    
				//Set values MD_TITLE
			    metaCopy.setMdTitle(data.get("FACEBOOK.USER.ID").asText());
			    
				//Set values MD_URL
			    metaCopy.setMdURL(data.get("FACEBOOK.DATA.WriterID").asText());
			    
				//Set values MD_SAME_COUNT
			    
			    
				//Set values MD_ISSUE_YN
			}
			if(data.has("FORUM.DATA.Seq")) 
			{
//				System.out.println("******** key ton tai  FACEBOOK.DATA.Seq  **************");
				//Set values MD_SEQ
				metaCopy.setMdSeq(data.get("FORUM.DATA.Seq").asLong());
				
				//Set values D_SEQ
				metaCopy.setdSeq((data.get("FORUM.DATA.CrawlStamp").asLong()));
				
				//Set values MD_PSEQ
				
				//Set values MD_DATE
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
			    Date date = new Date();
			    metaCopy.setMdDate(formatter.format(date).toString());
				
				//Set values S_SEQ
			    metaCopy.setsSeq((data.get("COMMON.SITE.Seq").asLong()));
			    
				//Set values MD_SITENAME
			    metaCopy.setMdSiteName(data.get("COMMON.SITE.Name").asText());
			    
				//Set values MD_MENUNAWE
//			    metaCopy.setMdMenuName(data.get("MAIN.BOARD.Name").asText());
			    
				//Set values MD_TITLE
			    metaCopy.setMdTitle(data.get("FORUM.TOPIC.ID").asText());
			    
				//Set values MD_URL
			    metaCopy.setMdURL(data.get("FORUM.DATA.WriterID").asText());
			    
				//Set values MD_SAME_COUNT
			    
			    
				//Set values MD_ISSUE_YN
			}
			if(data.has("REPLY.DATA.Seq")) 
			{
//				System.out.println("******** key ton tai  REPLY.DATA.Seq  **************");
				//Set values MD_SEQ
				metaCopy.setMdSeq(data.get("REPLY.DATA.Seq").asLong());
				
				//Set values D_SEQ
				metaCopy.setdSeq((data.get("REPLY.DATA.CrawlStamp").asLong()));
				
				//Set values MD_PSEQ
				
				//Set values MD_DATE
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
			    Date date = new Date();
			    metaCopy.setMdDate(formatter.format(date).toString());
				
				//Set values S_SEQ
			    metaCopy.setsSeq((data.get("COMMON.SITE.Seq").asLong()));
			    
				//Set values MD_SITENAME
			    metaCopy.setMdSiteName(data.get("COMMON.SITE.Name").asText());
			    
				//Set values MD_MENUNAWE
			    metaCopy.setMdMenuName(data.get("MAIN.DATA.Seq").asText());
			    
				//Set values MD_TITLE
			    metaCopy.setMdTitle(data.get("MAIN.DATA.Title").asText());
			    
				//Set values MD_URL
			    metaCopy.setMdURL(data.get("MAIN.DATA.Link").asText());
			    
				//Set values MD_SAME_COUNT
			    
			    
				//Set values MD_ISSUE_YN
			}
		    
		    
		    //input into db
		    metaService.create(metaCopy);
		    
//		    System.out.println(metaCopy);
		    
		    listMeta.add(metaCopy);
		    
		}
		
//		return "Thanh cong meta 0 seq " + listMeta.get(0).getMdSeq();
	}
	
	@GetMapping(path = {"/{id}"})
	
	public Meta findOne(@PathVariable("id") int seq ) {
		return metaService.findByMdSeq(seq);
	}
//	
//	@PatchMapping(path = {"/{id}"})
//    public Menu update(@PathVariable("id") int menu_seq, @RequestBody Menu menu){
//        menu.setMenuSeq(menu_seq);
//        Menu menuOld = menuService.findByMenuSeq(menu_seq);
//        menuOld = menu;
//        return menuService.update(menuOld);
//    }
//
//    @DeleteMapping(path ={"/{id}"})
//    public Menu delete(@PathVariable("id") int menu_seq) {
//        return menuService.delete(menu_seq);
//    }
//
    @GetMapping
    public List<Meta> findAll(){
        return metaService.findAll();
    }
}
