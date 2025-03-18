// SPDX-FileCopyrightText: 2025 Deutsche Telekom AG and others
//
// SPDX-License-Identifier: Apache-2.0

import com.sun.tools.javac.tree.TreeInfo.types

function(
    name = "search",
    description = "Searches the internet.",
    params = types(
        string("query", "The Query to search for.")
    )
) { (url) ->
    httpGet(
        "https://api.search.brave.com/res/v1/web/search", headers = mapOf(
            "Accept" to "application/json",
            "X-Subscription-Token" to "BRAVE_KEY",
        )
    )
}
