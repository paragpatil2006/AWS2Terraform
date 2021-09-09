resource aws_iam_role testRole {
	name = "testRole"
	path = "/"
	description = "test description"
	assume_role_policy = <<EOF
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Principal": {
        "Federated": "arn:aws:iam::100000000000:oidc-provider/oidc.eks.ap-northeast-2.amazonaws.com/id/100020003000400050006000700080006"
      },
      "Action": "sts:AssumeRoleWithWebIdentity",
      "Condition": {
        "StringEquals": {
          "oidc.eks.ap-northeast-2.amazonaws.com/id/100020003000400050006000700080006:sub": "system:serviceaccount:kube-system:efs-csi-controller-sa"
        }
      }
    }
  ]
}
EOF
}

