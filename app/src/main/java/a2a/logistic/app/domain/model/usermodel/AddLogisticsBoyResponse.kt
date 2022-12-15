package a2a.logistic.app.domain.model.usermodel

import com.google.gson.annotations.SerializedName

data class AddLogisticsBoyResponse(

	@field:SerializedName("data")
	val result: Data? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class Data(

	@field:SerializedName("note")
	val note: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("bank_address")
	val bankAddress: String? = null,

	@field:SerializedName("about")
	val about: String? = null,

	@field:SerializedName("service_zipcode")
	val serviceZipcode: String? = null,

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("profile_image")
	val profileImage: String? = null,

	@field:SerializedName("user_type")
	val userType: String? = null,

	@field:SerializedName("file")
	val file: String? = null,

	@field:SerializedName("__v")
	val V: Int? = null,

	@field:SerializedName("bank_name")
	val bankName: String? = null,

	@field:SerializedName("commission")
	val commission: String? = null,

	@field:SerializedName("ifsc")
	val ifsc: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("commission_type")
	val commissionType: String? = null,

	@field:SerializedName("acc_number")
	val accNumber: String? = null,

	@field:SerializedName("acc_holder_name")
	val accHolderName: String? = null,

	@field:SerializedName("address")
	val address: String? = null,

	@field:SerializedName("seo_desc")
	val seoDesc: String? = null,

	@field:SerializedName("price_per_kg")
	val pricePerKg: String? = null,

	@field:SerializedName("mobile")
	val mobile: String? = null,

	@field:SerializedName("active")
	val active: Int? = null,

	@field:SerializedName("otp")
	val otp: Int? = null,

	@field:SerializedName("communication_zipcode")
	val communicationZipcode: String? = null,

	@field:SerializedName("seo_title")
	val seoTitle: String? = null,

	@field:SerializedName("update_date")
	val updateDate: String? = null,

	@field:SerializedName("email_otp")
	val emailOtp: Int? = null,

	@field:SerializedName("price_per_pack")
	val pricePerPack: String? = null,

	@field:SerializedName("master")
	val master: Any? = null,

	@field:SerializedName("branch_code")
	val branchCode: String? = null,

	@field:SerializedName("full_name")
	val fullName: String? = null,

	@field:SerializedName("deleted")
	val deleted: Int? = null,

	@field:SerializedName("cod")
	val cod: Any? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("created_date")
	val createdDate: String? = null,

	@field:SerializedName("delivery_city")
	val deliveryCity: List<Any?>? = null,

	@field:SerializedName("customer_support_city")
	val customerSupportCity: List<String?>? = null
)
