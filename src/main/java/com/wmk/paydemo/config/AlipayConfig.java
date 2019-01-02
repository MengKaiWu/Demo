package com.wmk.paydemo.config;

public class AlipayConfig {
    // 商户appid，即是APPID对应的支付宝收款账户
    public static String APPID = "2016092100564241";
    // 私钥 pkcs8格式的，商户自己持有的私钥
    public static String RSA_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCE8RdV8bx1Ofv5E8B31/Qp512qSSsXB6b4c7OmKgZ7GwnqNLYMyMZR+rJ32ubCosdzT0D9/k7htQ2etFov0rwZRPibnW4WlBXTX+vCuS3SOs/TDuBFxNDsvpWvWN04aVddsaphnquZdIGIjgQpnO75syczkCTVHLxeSt9pEsGbE9zsiVpyae9McpKGSyYSsnRvc8qMQcQb6floajPBNVHs88twK9wMS7UNmOnxy3RH9poADWHpjO5F0RZwB5TaCAbYu+CkzyHYJjW6+vSoeIOpvrZMizhFc/2ZxKiUARLkJiSTLkJ7teezx//hPOih1q9xzPPnAJkiOYRd3QqxL3VvAgMBAAECggEAFkRPdUy9FSF2K9z8EtawBcjD7n684emdNOYkRAOr/DimK31StMd4OEj2VY7rsdQT9iNjLmfHDJUHx/pLVNFGQjFENsRiqRN6qGHbmkzr+Ndy8dX/CJCTseOmLK2EuCskwAO/FwS9l0FlZNrspY+sk1RHj6JoGO3sOxrtWqsSlIe7YI/uvrnLFdcjZXZC5KXbG/EqqY7hn/4z7J6m+Z2iSVnPUc9iyaCk5JC73LPoX1veR1A0duqRq2Pgx1eHsZ+RusdJkQRHobpsR8NlYl/9BWn5QuncMGLffpfPpuSgdGRxaMGzDLRFq8p3vZY+KYdpIenYIUMh4V+4Zv6EF9PpuQKBgQDctlbh59jEnHRLT/H4pZd1fkfFYJ1z2wK7V0Obvb0gphn7UukYzwxqx0mtf/KmpEpkXO8NYg4nUq8J3qcazasisYVk2mYIaV6FGSiAqOCebqgPE1AcFdlb/+i2Q441YpIL+Trlhj3NdvSKRJbvGhQReHZ7Az3P7BrqdXiLS8UtCwKBgQCaMleFhBgt5ByROIB9PAUCZfudL7XezCL4gMz0l/dv00pkukqPuMVmX0WwCgZlISj28d0m3OvKnLbQHQrE+gap12IKQSrK4sGsPksjbZGc2tc/6Xf0Fy9a7RAoW2c+OE4FB6z7vte8NDGehDsrDBKwCmLmzSf/d/0d5AiJ+eEvrQKBgEyyeGKsZKF+FNOPBnD3ajiEF4C5YD3AX6SmYHIgbzaHQgQZ/bKHULNSaYIHMlVCRi+2M8QczPpRO05ctwkTa2L0+XvggRBvPU9XPMHo7ZVgsrn6Zh48YXoc5ctgkmxuwn2ysArOqW9a5QOfbivMjii8CcAZkkNMstXC2I7fV7edAoGAI9mSeatVh83iSm0tinBa5czaLBh8m1kwxEAF5tQyJiCkyjh5v2KBGqUJ6bza8cY85PUkqrVwaMH4yvgFmfhbdj9qPuIZ1ePUjXxKMel2klZa9zQLvIdrbiNxv0BJB7FFimvXbwxW0h38b1NlAkQjUCSKDAkkxIOcKMfsqE+daF0CgYEAzkzNNboyjh/Omg9a306WHyhcU4IVDuzd39VS0XaCyv3qHQSs1LqhCBweagSTSNo+Yr1DnDYxLHHplVef3bQnDjPqBaHy2bw7sTR+yaNmJd6G+ohA/4tsOISFGfYFVc/a/hZLHzQa7U08FOTvIHHil2ZU2myteMA+NYuGi9+LhtM=";
    // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "";
    // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public static String return_url = "";
    // 请求网关地址
    //沙箱环境
    public static String SXURL = "https://openapi.alipaydev.com/gateway.do";
    //生产环境
    //public static String URL = "https://openapi.alipay.com/gateway.do";
    // 编码
    public static String CHARSET = "UTF-8";
    // 返回格式
    public static String FORMAT = "json";
    // 支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA2CG0ms4NpPxFejPf843PJOf1b3BQH2pggKdrTkGS7E5Oadx5oyYnv98Gj+1YR3VO6GJ7Dp8dkU6Vwgn9XJgiUSuf9QtT9jCW6XmwjG5R2DyGdNW5LvK8IkQ1LFJp/ewY/TwCpoetR1RoFbrvEx7iXxn1lh9eOzYiGyEVOwUVMBCmILZt91PxNx5h6H26ukrO/HMm4uq0Ml/Kcn4rfjG5pHo2hVOFI2G5OaXTph3NO1ZWFwsspAIxM63/4Kop6VPZ6LQGpCaAvGOq5u4BEe9afRIMthgXn0fEiUJevekVicPUn890oTrGZ6PN5x4uqmWel8UzRdJoI/8Pw5Tt8EcA4QIDAQAB";
    // 日志记录目录
    public static String log_path = "/log";
    // RSA2
    public static String SIGNTYPE = "RSA2";
}
