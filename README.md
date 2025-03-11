<!--
SPDX-FileCopyrightText: 2023 Deutsche Telekom AG

SPDX-License-Identifier: CC0-1.0    
-->
# Welcome to the Arc Agent Init Project

The following project is a demo project for the Arc Agent Framework. 
It can also be used to kickstart a new Spring Boot project that uses the Arc Agent Framework.

## How to run

#### 1. Add language model configuration

Add an OpenAI API-KEY to `config/application.yml` or as the environment variable, `OPENAI_API_KEY`.

```
arc:
  ai:
    clients:
      - id: GPT-4o
        model-name: GPT-4o
        api-key: ${OPENAI_API_KEY}
        client: openai
      - id: llama3.3
        modelName: llama3.3
        client: ollama
```

Alternatively, you can run an LLM locally with the `ollama` client, see https://ollama.com/,
and change the model in the agent `assistant.agent.kts` file accordingly.

```kts
agent {
    name = "assistant-agent"
    model = { "llama3.3" }
    ...
}
```

#### 2. Start the Application

Start the Demo Application like a normal Spring Boot application.
This requires the port 8080 to be available.

```bash
  ./gradlew bootRun
```


#### 3. Access the Agent

You can chat with the Arc Agents using the [Arc View](https://github.com/eclipse-lmos/arc-view).

Simply open https://eclipse.dev/lmos/chat/index.html?agentUrl=http://localhost:8080#/chat in your browser.

Alternatively, the Graphiql interface is also available, under http://localhost:8080/graphiql?path=/graphql.

Example Request:

```graphql
subscription {
    agent(
        agentName: "assistant-agent"
        request: {
            conversationContext: {
                conversationId: "1"
            }
            systemContext: [],
            userContext: {
                userId: "1234",
                profile: [{
                    key: "name",
                    value: "Pat"
                }]
            },
            messages: [
                {
                    role: "user",
                    content: "Hi",
                    format: "text",
                }
            ]
        }
    ) {
        messages {
            content
        }
    }
}
```


#### 4. Add new Agents

New agents can be added to the `agents` folder located at the root of the project.
The folder contains a default agent `assistant-agent` that can be used as a template.


#### 5. Tracing

The Arc Framework supports tracing with Micrometer Tracing. 
See [Arc Tracing](https://eclipse.dev/lmos/docs/arc/tracing/) for more information.

By default, tracing is disabled in the project. To enable it, update your application.yaml as follows:
```yaml
management:
  tracing:
    enabled: true
```

To use tracing with [Zipkin](https://zipkin.io/pages/quickstart), start a Zipkin server using Docker:
```shell
docker run -d -p 9411:9411 openzipkin/zipkin
```

Open the Zipkin UI in your browser at [http://localhost:9411](http://localhost:9411/) to watch the traces of your Arc Agents in real time.

## Code of Conduct

This project has adopted the [Contributor Covenant](https://www.contributor-covenant.org/) in version 2.1 as our code of conduct. Please see the details in our [CODE_OF_CONDUCT.md](CODE_OF_CONDUCT.md). All contributors must abide by the code of conduct.

By participating in this project, you agree to abide by its [Code of Conduct](./CODE_OF_CONDUCT.md) at all times.

## Licensing

This project follows the [REUSE standard for software licensing](https://reuse.software/).    
Each file contains copyright and license information, and license texts can be found in the [./LICENSES](./LICENSES) folder. For more information visit https://reuse.software/.    
You can find a guide for developers at https://telekom.github.io/reuse-template/.   
