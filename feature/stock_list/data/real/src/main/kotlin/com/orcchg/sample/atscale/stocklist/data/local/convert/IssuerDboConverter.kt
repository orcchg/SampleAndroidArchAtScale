package com.orcchg.sample.atscale.stocklist.data.local.convert

import com.orcchg.sample.atscale.stocklist.domain.Issuer
import com.orcchg.sample.atscale.stocklist.data.local.model.IssuerDbo
import com.orcchg.sample.atscale.util.Converter
import javax.inject.Inject

class IssuerDboConverter @Inject constructor() : Converter<IssuerDbo, Issuer> {

    override fun convert(from: IssuerDbo): Issuer =
        Issuer(
            name = from.name,
            country = from.country,
            ticker = from.ticker,
            logoUrl = from.logoUrl
        )

    override fun revert(from: Issuer): IssuerDbo =
        IssuerDbo(
            name = from.name,
            country = from.country,
            ticker = from.ticker,
            logoUrl = from.logoUrl
        )
}
