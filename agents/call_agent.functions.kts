import org.eclipse.lmos.arc.agents.conversation.AssistantMessage
import org.eclipse.lmos.arc.agents.conversation.Conversation
import org.eclipse.lmos.arc.agents.conversation.latest

// SPDX-FileCopyrightText: 2025 Deutsche Telekom AG and others
//
// SPDX-License-Identifier: Apache-2.0


function(
    name = "call_agent",
    description = "Calls another agent.",
    params = types(string("name", "the name of the agent to call."))
) { (arg) ->
    val agentName = arg.toString()

    emitMessage("Calling $agentName...")
    memory("last_call_agent", agentName)

    val conversation = get<Conversation>()
    val resultConversation = callAgent(agentName, conversation).getOrNull()
    resultConversation?.latest<AssistantMessage>()?.content?.toString() ?: "I couldn't reach the agent."
}
