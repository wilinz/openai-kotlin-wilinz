package com.aallam.openai.api.completion

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A completion generated by GPT-3.
 *
 * [documentation](https://beta.openai.com/docs/api-reference/create-completion)
 */
@Serializable
public data class Choice(

    /**
     * The generated text. Will include the prompt if [CompletionRequest.echo] is true
     */
    @SerialName("text")
    public val text: String,

    /**
     * This index of this completion in the returned list.
     */
    @SerialName("index")
    public val index: Int,

    /**
     * The log probabilities of the chosen tokens and the top [CompletionRequest.logprobs] tokens.
     */
    @SerialName("logprobs")
    public val logprobs: Logprobs? = null,

    /**
     * The reason why GPT-3 stopped generating, for example "length".
     */
    @SerialName("finish_reason")
    public val finishReason: String? = null,
)
