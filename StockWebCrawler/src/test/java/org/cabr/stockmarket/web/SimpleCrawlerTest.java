package org.cabr.stockmarket.web;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.*;

import org.cabr.stockmarket.web.SimpleCrawler;


public class SimpleCrawlerTest {

	SimpleCrawler crawler;
	
	@Before
	public void setUp(){
		 crawler = new SimpleCrawler();
	}
	
	@Test
	public void returnErrorConnection(){
		assertFalse(crawler.parse("http://dummy.site.orga"));
		assertTrue(crawler.parse("http://stooq.org"));
		assertTrue(crawler.parse("http://stooq.pl/q/d/?s=msi.us"));
		assertTrue(crawler.parse("http://stooq.pl/q/d/l/?s=msi.us&o=1111111"));
	}
	
	@Test
	public void fetchFile() {
		assertFalse(crawler.downloadFile("http/dummy.site.orga@home"));
		assertTrue(crawler.downloadFile("http://stooq.pl/q/d/l/?s=msi.us&o=1111111"));
		assertTrue(crawler.downloadFile("http://stooq.pl/q/d/l/?s=msi.us&d1=20130225&d2=20140502&i=w&o=1111111"));
	}
	
	@Test
	public void combineParametersAndCreateValidURL(){
		assertEquals(crawler.parse("stooq.pl", "msi.us", "d", "1111111"), "http://stooq.pl/q/d/l/?s=msi.us&i=d&o=1111111");
		assertEquals(crawler.parse("http://stooq.pl", "msi.us", "w", "1111111"), "http://stooq.pl/q/d/l/?s=msi.us&i=w&o=1111111");
		assertEquals(crawler.parse("stooq.pl", "msi.us", "w", "1111111") , "http://stooq.pl/q/d/l/?s=msi.us&i=w&o=1111111");
		assertEquals(crawler.parse("stooq.pl", "msi.us", "m", "1111111") , "http://stooq.pl/q/d/l/?s=msi.us&i=m&o=1111111");
		assertEquals(crawler.parse("stooq.pl", "msi.us", "q", "1111111") , "http://stooq.pl/q/d/l/?s=msi.us&i=q&o=1111111");
		assertEquals(crawler.parse("stooq.pl", "msi.us", "y", "1111111") , "http://stooq.pl/q/d/l/?s=msi.us&i=y&o=1111111");
		
		assertEquals(crawler.parse("stooq.pl", "msi.us", "20130225", "20140502" , "y" , "1111111") , "http://stooq.pl/q/d/l/?s=msi.us&d1=20130225&d2=20140502&i=y&o=1111111");
		assertEquals(crawler.parse("stooq.pl", "msi.us", "20140502", "20130225" , "w" , "1111111") , "http://stooq.pl/q/d/l/?s=msi.us&d1=20130225&d2=20140502&i=w&o=1111111");
	}
}
