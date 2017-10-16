package cn.jcomm.test.thridpack.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jowang on 2017/4/22 0022.
 */
public class HelloVelocity {
    public static void main(String[] args) throws IOException {
        VelocityEngine ve = new VelocityEngine();
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());

        ve.init();

        Template t = ve.getTemplate("hellovelocity.vm");
        VelocityContext ctx = new VelocityContext();

        ctx.put("name", "velocity");
        ctx.put("date", (new Date()).toString());

        List temp = new ArrayList();
        temp.add("1");
        temp.add("2");
        ctx.put("list", temp);

        StringWriter sw = new StringWriter();

        t.merge(ctx, sw);

        FileWriter fw=new FileWriter("a.txt");
        fw.write(sw.toString());
        fw.close();
        System.out.println(sw.toString());
    }
}
