package me.leon.encode.base

import java.math.BigInteger
import me.leon.ext.toUnicodeChar

/**
 * ported from https to //github.com/Parkayun/base65536/blob/master/base65536/core.py
 * https://base65536.penclub.club/
 *
 * @author Leon
 * @since 2022-09-06 16 to 09
 * @email to deadogone@gmail.com
 */
val BLOCK_START =
    mapOf(
        0 to 13_312,
        1 to 13_568,
        2 to 13_824,
        3 to 14_080,
        4 to 14_336,
        5 to 14_592,
        6 to 14_848,
        7 to 15_104,
        8 to 15_360,
        9 to 15_616,
        10 to 15_872,
        11 to 16_128,
        12 to 16_384,
        13 to 16_640,
        14 to 16_896,
        15 to 17_152,
        16 to 17_408,
        17 to 17_664,
        18 to 17_920,
        19 to 18_176,
        20 to 18_432,
        21 to 18_688,
        22 to 18_944,
        23 to 19_200,
        24 to 19_456,
        25 to 19_968,
        26 to 20_224,
        27 to 20_480,
        28 to 20_736,
        29 to 20_992,
        30 to 21_248,
        31 to 21_504,
        32 to 21_760,
        33 to 22_016,
        34 to 22_272,
        35 to 22_528,
        36 to 22_784,
        37 to 23_040,
        38 to 23_296,
        39 to 23_552,
        40 to 23_808,
        41 to 24_064,
        42 to 24_320,
        43 to 24_576,
        44 to 24_832,
        45 to 25_088,
        46 to 25_344,
        47 to 25_600,
        48 to 25_856,
        49 to 26_112,
        50 to 26_368,
        51 to 26_624,
        52 to 26_880,
        53 to 27_136,
        54 to 27_392,
        55 to 27_648,
        56 to 27_904,
        57 to 28_160,
        58 to 28_416,
        59 to 28_672,
        60 to 28_928,
        61 to 29_184,
        62 to 29_440,
        63 to 29_696,
        64 to 29_952,
        65 to 30_208,
        66 to 30_464,
        67 to 30_720,
        68 to 30_976,
        69 to 31_232,
        70 to 31_488,
        71 to 31_744,
        72 to 32_000,
        73 to 32_256,
        74 to 32_512,
        75 to 32_768,
        76 to 33_024,
        77 to 33_280,
        78 to 33_536,
        79 to 33_792,
        80 to 34_048,
        81 to 34_304,
        82 to 34_560,
        83 to 34_816,
        84 to 35_072,
        85 to 35_328,
        86 to 35_584,
        87 to 35_840,
        88 to 36_096,
        89 to 36_352,
        90 to 36_608,
        91 to 36_864,
        92 to 37_120,
        93 to 37_376,
        94 to 37_632,
        95 to 37_888,
        96 to 38_144,
        97 to 38_400,
        98 to 38_656,
        99 to 38_912,
        100 to 39_168,
        101 to 39_424,
        102 to 39_680,
        103 to 39_936,
        104 to 40_192,
        105 to 40_448,
        106 to 41_216,
        107 to 41_472,
        108 to 41_728,
        109 to 42_240,
        110 to 67_072,
        111 to 73_728,
        112 to 73_984,
        113 to 74_240,
        114 to 77_824,
        115 to 78_080,
        116 to 78_336,
        117 to 78_592,
        118 to 82_944,
        119 to 83_200,
        120 to 92_160,
        121 to 92_416,
        122 to 131_072,
        123 to 131_328,
        124 to 131_584,
        125 to 131_840,
        126 to 132_096,
        127 to 132_352,
        128 to 132_608,
        129 to 132_864,
        130 to 133_120,
        131 to 133_376,
        132 to 133_632,
        133 to 133_888,
        134 to 134_144,
        135 to 134_400,
        136 to 134_656,
        137 to 134_912,
        138 to 135_168,
        139 to 135_424,
        140 to 135_680,
        141 to 135_936,
        142 to 136_192,
        143 to 136_448,
        144 to 136_704,
        145 to 136_960,
        146 to 137_216,
        147 to 137_472,
        148 to 137_728,
        149 to 137_984,
        150 to 138_240,
        151 to 138_496,
        152 to 138_752,
        153 to 139_008,
        154 to 139_264,
        155 to 139_520,
        156 to 139_776,
        157 to 140_032,
        158 to 140_288,
        159 to 140_544,
        160 to 140_800,
        161 to 141_056,
        162 to 141_312,
        163 to 141_568,
        164 to 141_824,
        165 to 142_080,
        166 to 142_336,
        167 to 142_592,
        168 to 142_848,
        169 to 143_104,
        170 to 143_360,
        171 to 143_616,
        172 to 143_872,
        173 to 144_128,
        174 to 144_384,
        175 to 144_640,
        176 to 144_896,
        177 to 145_152,
        178 to 145_408,
        179 to 145_664,
        180 to 145_920,
        181 to 146_176,
        182 to 146_432,
        183 to 146_688,
        184 to 146_944,
        185 to 147_200,
        186 to 147_456,
        187 to 147_712,
        188 to 147_968,
        189 to 148_224,
        190 to 148_480,
        191 to 148_736,
        192 to 148_992,
        193 to 149_248,
        194 to 149_504,
        195 to 149_760,
        196 to 150_016,
        197 to 150_272,
        198 to 150_528,
        199 to 150_784,
        200 to 151_040,
        201 to 151_296,
        202 to 151_552,
        203 to 151_808,
        204 to 152_064,
        205 to 152_320,
        206 to 152_576,
        207 to 152_832,
        208 to 153_088,
        209 to 153_344,
        210 to 153_600,
        211 to 153_856,
        212 to 154_112,
        213 to 154_368,
        214 to 154_624,
        215 to 154_880,
        216 to 155_136,
        217 to 155_392,
        218 to 155_648,
        219 to 155_904,
        220 to 156_160,
        221 to 156_416,
        222 to 156_672,
        223 to 156_928,
        224 to 157_184,
        225 to 157_440,
        226 to 157_696,
        227 to 157_952,
        228 to 158_208,
        229 to 158_464,
        230 to 158_720,
        231 to 158_976,
        232 to 159_232,
        233 to 159_488,
        234 to 159_744,
        235 to 160_000,
        236 to 160_256,
        237 to 160_512,
        238 to 160_768,
        239 to 161_024,
        240 to 161_280,
        241 to 161_536,
        242 to 161_792,
        243 to 162_048,
        244 to 162_304,
        245 to 162_560,
        246 to 162_816,
        247 to 163_072,
        248 to 163_328,
        249 to 163_584,
        250 to 163_840,
        251 to 164_096,
        252 to 164_352,
        253 to 164_608,
        254 to 164_864,
        255 to 165_120,
        -1 to 5376,
    )

val B2 = mutableMapOf<Int, Int>().apply { putAll(BLOCK_START.values.zip(BLOCK_START.keys)) }

fun ByteArray.base65536() =
    asIterable()
        .chunked(2) {
            val b1 = it.first().toInt() and 0xff
            val b2 = if (it.size > 1) it.last().toInt() and 0xff else -1
            val codePoint = BLOCK_START[b2]!! + b1
            codePoint.toUnicodeChar()
        }
        .joinToString("")

fun String.base65536() = toByteArray().base65536()

fun String.base65536Decode2String() = base65536Decode().decodeToString()

fun String.base65536Decode() =
    toByteArray(Charsets.UTF_32BE)
        .asIterable()
        .chunked(4)
        .map {
            val code = BigInteger(it.toByteArray()).toInt()
            val b1 = code and 0xff
            val b2 = B2[code - b1] ?: -1
            if (b2 == -1) listOf(b1.toByte()) else listOf(b1.toByte(), b2.toByte())
        }
        .flatten()
        .toByteArray()
