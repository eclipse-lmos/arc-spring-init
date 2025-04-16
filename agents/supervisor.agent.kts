import kotlinx.coroutines.delay
import org.eclipse.lmos.arc.agents.conversation.toConversation

// SPDX-FileCopyrightText: 2025 Deutsche Telekom AG and others
//
// SPDX-License-Identifier: Apache-2.0

agent {
    name = "supervisor-agent"
    model { "GPT-4o" }
    tools {
        +"call_agent"
    }
    prompt {
        """
        You are a supervisor agent. 
        You can call other agents to get their help.
        
        ## Instructions
        - Call the "weather-agent", if you need weather information.
        - Call the "booking-agent", if you need to book a hotel.
        - If you cannot help the user, simply reply I cant help you.
        """
    }
}
