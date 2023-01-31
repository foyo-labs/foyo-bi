package com.foyo.bi

import com.foyo.bi.router.apiRoutes
import org.springframework.context.support.beans

val beans = beans {
  bean { apiRoutes(ref()) }
}


