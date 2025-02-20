package com.anthunt.terraform.generator.aws.service.vpc.model;

import com.anthunt.terraform.generator.core.model.terraform.TerraformSource;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import software.amazon.awssdk.services.ec2.model.Vpc;

@Data
@ToString
@Builder
public class AWSVpc implements TerraformSource {
    private static final String TERRAFORM_RESOURCE_NAME = "aws_vpc";
    private Vpc vpc;
    private boolean enableDnsSupport;
    private boolean enableDnsHostnames;

    @Override
    public String getTerraformResourceName() {
        return TERRAFORM_RESOURCE_NAME;
    }

    @Override
    public String getResourceId() {
        return vpc.vpcId();
    }

    @Override
    public String getResourceName() {
        return vpc.vpcId();
    }
}
