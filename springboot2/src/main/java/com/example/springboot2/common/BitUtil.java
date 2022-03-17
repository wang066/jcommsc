//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.springboot2.common;

public final class BitUtil {
    private static final int[] INTEGER_MASKS = new int[32];
    private static final long[] LONG_MASKS = new long[64];

    public BitUtil() {
    }

    public static boolean is(int value, int index) {
        return index > -1 && index < 32 && (value & INTEGER_MASKS[index]) != 0;
    }

    public static int set(int value, int index) {
        return index > -1 && index < 32 ? value | INTEGER_MASKS[index] : value;
    }

    public static int clear(int value, int index) {
        return index > -1 && index < 32 ? value & ~INTEGER_MASKS[index] : value;
    }

    public static boolean is(long value, int index) {
        return index > -1 && index < 64 && (value & LONG_MASKS[index]) != 0L;
    }

    public static long set(long value, int index) {
        return index > -1 && index < 64 ? value | LONG_MASKS[index] : value;
    }

    public static long clear(long value, int index) {
        return index > -1 && index < 64 ? value & ~LONG_MASKS[index] : value;
    }

    // public static BitSet hexToBitSet(String data) {
    //     return StringUtil.isNotEmpty(data) ? BitSet.valueOf(ByteUtil.fromHex(data)) : new BitSet();
    // }

    // public static String bitSetToHex(BitSet data) {
    //     return data != null ? ByteUtil.toHex(data.toByteArray()) : "";
    // }

    static {
        int i;
        for(i = 0; i < 32; ++i) {
            INTEGER_MASKS[i] = 1 << i;
        }

        for(i = 0; i < 64; ++i) {
            LONG_MASKS[i] = 1L << i;
        }

    }
}
