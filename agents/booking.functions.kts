// SPDX-FileCopyrightText: 2025 Deutsche Telekom AG and others
//
// SPDX-License-Identifier: Apache-2.0

function(
    name = "book_hotel",
    description = "Books a hotel.",
    params = types(
        string("name", "The name of the hotel to book.")
    )
) { (hotel) ->
  """
      $hotel was booked successfully.
  """
}

function(
    name = "list_hotels",
    description = "List available hotels.",
) {
    """
     Name: The King's Hotel
     Price: 100 euros
     
     Name: The Prince Hotel
     Price: 80 euros
     
     Name: The Queen Hotel
     Price: 200 euros
  """
}