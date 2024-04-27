package coinconverter.model;

import com.google.gson.annotations.SerializedName;

public record Coin(@SerializedName("base_code") String basecode,
                   @SerializedName("target_code") String targetcode,
                   @SerializedName("conversion_rate") double conversionrate) {
}
