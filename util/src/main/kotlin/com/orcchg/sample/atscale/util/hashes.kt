package com.orcchg.sample.atscale.util

import java.security.MessageDigest

/**
 * Методы хеширования.
 */
enum class HashAlgorithm(val notation: String) {
    SHA1("SHA-1"),
    SHA256("SHA-256"),
    SHA512("SHA-512")
}

fun hash(algorithm: HashAlgorithm, vararg args: ByteArray): ByteArray =
    MessageDigest.getInstance(algorithm.notation).let { digest ->
        args.forEach { data -> digest.update(data) }
        digest.digest()
    }

fun CharSequence.goodHashCode(): Long {
    var h = 1125899906842597L // big prime
    this.forEach { h = 31 * h + it.toInt() }
    return h
}
