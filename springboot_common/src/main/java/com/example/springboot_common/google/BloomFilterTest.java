package com.example.springboot_common.google;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.google.common.primitives.Ints;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class BloomFilterTest {
    public static void main(String[] args) throws IOException {
        // BloomFilter bloomFilter=BloomFilter.create(Funnels.stringFunnel(Charset.defaultCharset(), , ), , );
        // 初始化一个存储string数据的布隆过滤器，初始化大小1w, 错误率为0.1%
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), 1000000, 0.001);
        // bloomFilter.put(Ints.toByteArray())
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        bloomFilter.writeTo(out);

        System.out.println(out.size());
    }
}
