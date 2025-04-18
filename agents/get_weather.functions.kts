// SPDX-FileCopyrightText: 2025 Deutsche Telekom AG and others
//
// SPDX-License-Identifier: Apache-2.0


function(
    name = "get_weather",
    description = "Returns the current weather.",
    params = types(
        string("location", "the location to get the weather for."),
    )
) { (location) ->
    """The weather is sunny in $location. A lovely 32 degrees celsius."""
}
