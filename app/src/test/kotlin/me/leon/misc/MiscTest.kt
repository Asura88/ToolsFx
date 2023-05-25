package me.leon.misc

import kotlin.test.*
import me.leon.misc.net.*

/**
 * @author Leon
 * @since 2023-01-31 16:25
 * @email deadogone@gmail.com
 */
class MiscTest {
    @Test
    fun port() {
        println("127.0.0.1".connect(7890, 20))
        val ports = 7882..10_000
        ports.filter { "127.0.0.1".connect(it) >= 0 }.forEach { println("~~~~~~~~$it") }
    }

    @Test
    @Ignore
    fun portAsync() {
        println("baidu.com".portScan())
    }

    @Test
    @Ignore
    fun lanScan() {
        println("192.168.0".lanScan())
    }

    @Test
    fun cronExplain() {

        val corns =
            arrayOf(
                "30 * * * ?",
                "30 * * * * ?",
                "30 10 * * * ?",
                "30 10 1 20 * ?",
                "30 10 1 20 10 ? *",
                "30 10 1 20 10 ? 2011",
                "30 10 1 ? 10 SUN 2011",
                "5,30,45 * * * * ?",
                "15/5 * * * * ?",
                "*/15 * * * * ?",
                "15-45 * * * * ?",
                "15-30/5 * * * * ?",
                "0 15 10 LW * ?",
                "0 15 10 ? * 5L",
                "0 15 10 ? * 5#3",
                "0,5,15,17,25,32,38,45 0,17,24,36 * * * ?",
                "0/30 0 4/6 * * ?",
                "0 1 1/5 * *",
                "0 0 12 ? * WED",
                "0 15 10 ? * MON-FRI",
                "0 15 10 ? * 6L 2002-2005",
            )

        corns
            .map { CronExpression(it.trim()) }
            .forEach { println(it.expression + " " + it.explain()) }
    }

    @Test
    fun ieee754() {
        val floatToRawIntBits = java.lang.Float.floatToRawIntBits(220.5F)
        println(Integer.toBinaryString(floatToRawIntBits))
        println(Integer.toHexString(floatToRawIntBits))
        println(Integer.toBinaryString(java.lang.Float.floatToRawIntBits(-220.5F)))
        println(java.lang.Long.toBinaryString(java.lang.Double.doubleToRawLongBits(1.111)))
        println(java.lang.Long.toHexString(java.lang.Double.doubleToRawLongBits(1.111)))
        println(java.lang.Long.toBinaryString(java.lang.Double.doubleToRawLongBits(-1.111)))
        println(java.lang.Long.toHexString(java.lang.Double.doubleToRawLongBits(-1.111)))
    }

    @Test
    fun githubMirror() {
        val file = "https://github.com/Leon406/ToolsFx/blob/dev/testdata/sm2/sm_qd_data.txt"
        val url = "https://raw.githubusercontent.com/Leon406/SubCrawler/main/sub/share/host"

        println(url.githubMirror())
        println()
        println(file.githubMirror())
    }

    @Test
    fun romanNumber() {
        val str = "399"
        println(str.roman())
        repeat(3999) { assertEquals(it + 1, (it + 1).toRoman().romanToInt()) }
    }
}
