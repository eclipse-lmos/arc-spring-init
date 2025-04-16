import kotlinx.coroutines.delay
import org.eclipse.lmos.arc.agents.conversation.AssistantMessage
import org.eclipse.lmos.arc.agents.conversation.toConversation

// SPDX-FileCopyrightText: 2025 Deutsche Telekom AG and others
//
// SPDX-License-Identifier: Apache-2.0

agent {
    name = "booking-agent"
    prompt {
        """
        You are a booking agent that helps customers to book hotels.

       ## Instructions
       - If you cannot help the user, simply reply I cant help you
       - Use the list hotels function to list all available hotels.
       - Use the booking function to book a hotel.
     """
    }
    tools {
        +"book_hotel"
        +"list_hotels"
    }
}