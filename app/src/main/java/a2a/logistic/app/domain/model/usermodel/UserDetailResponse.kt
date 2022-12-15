package a2a.logistic.app.domain.model.usermodel

import com.google.gson.annotations.SerializedName

data class UserDetailResponse(

	@field:SerializedName("doc")
	val doc: String? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)
