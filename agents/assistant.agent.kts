import kotlinx.coroutines.delay
import org.eclipse.lmos.arc.agents.conversation.toConversation

// SPDX-FileCopyrightText: 2025 Deutsche Telekom AG and others
//
// SPDX-License-Identifier: Apache-2.0

agent {
    name = "assistant-agent"
    model { "GPT-4o" }
    filterInput {
    }
    filterOutput {
        -"bad word"
    }
    tools {
        +"get_weather"
    }
    prompt {
        """
        You are an assistant. Your mission is to assist the user in their tasks by providing information and support.
        """
    }
}
