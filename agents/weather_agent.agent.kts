import kotlinx.coroutines.delay
import org.eclipse.lmos.arc.agents.conversation.AssistantMessage
import org.eclipse.lmos.arc.agents.conversation.toConversation

// SPDX-FileCopyrightText: 2025 Deutsche Telekom AG and others
//
// SPDX-License-Identifier: Apache-2.0

agent {
    name = "weather-agent"
    prompt {
        """
        You are a professional weather service. You provide weather data to your users.
        You have access to real-time weather data with the get_weather function.

       ## Instructions
       - If you cannot help the user, simply reply I cant help you
       - Use the get_weather function to get the weather data.
       - Use multiple function calls if more locations are specified.
     """
    }
    tools {
        +"get_weather"
    }
}