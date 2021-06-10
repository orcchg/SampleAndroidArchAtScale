package com.orcchg.sample.atscale.stocklist.data.remote.convert

import com.orcchg.sample.atscale.stocklist.data.local.model.IssuerDbo
import com.orcchg.sample.atscale.stocklist.data.remote.model.IssuerEntity
import com.orcchg.sample.atscale.util.Converter
import javax.inject.Inject

class IssuerNetworkToDboConverter @Inject constructor() : Converter<IssuerEntity, IssuerDbo> {

    override fun convert(from: IssuerEntity): IssuerDbo =
        IssuerDbo(
            ticker = from.ticker,
            country = from.country,
            name = from.name,
            logoUrl = from.logoUrl
        )
}
