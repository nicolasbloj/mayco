package com.nab.mayco;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MaycoApplication.class},
    webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

public class ProjectServiceIntegrationTest {

  /*
   * private Logger logger = Logger.getLogger(ProjectServiceUnitTest.class);
   * 
   * @Autowired
   * 
   * @Qualifier("ProjectService") private ProjectService service;
   * 
   * @Before public void setUp() {
   * 
   * logger.info(" INIT JUNIT TEST - BEFORE ");
   * 
   * File file = new File("/home/nab/Pictures/1.png");
   * 
   * byte[] bFile = new byte[(int) file.length()];
   * 
   * try { FileInputStream fileInputStream = new FileInputStream(file); // convert file into array
   * of bytes fileInputStream.read(bFile); fileInputStream.close(); } catch (Exception e) {
   * e.printStackTrace(); }
   * 
   * 
   * this.service.add(new Project("name123", bFile)); }
   * 
   * @Test public void testAdd() { List<Project> projects = this.service.list();
   * 
   * logger.info("projects " + projects.size()); }
   */

}
