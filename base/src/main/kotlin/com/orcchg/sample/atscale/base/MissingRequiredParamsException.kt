package com.orcchg.sample.atscale.base

import java.lang.RuntimeException

class MissingRequiredParamsException(msg: String?) : RuntimeException(msg)