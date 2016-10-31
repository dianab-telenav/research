package com.telenav.playground.commander.permission;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link SocialConnection}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableSocialConnection.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "SocialConnection"})
final class ImmutableSocialConnection
    implements SocialConnection {
  private final String emailAddress;

  private ImmutableSocialConnection(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  /**
   * @return The value of the {@code emailAddress} attribute
   */
  @Override
  public String emailAddress() {
    return emailAddress;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link SocialConnection#emailAddress() emailAddress} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for emailAddress
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableSocialConnection withEmailAddress(String value) {
    if (this.emailAddress.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "emailAddress");
    return new ImmutableSocialConnection(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableSocialConnection} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableSocialConnection
        && equalTo((ImmutableSocialConnection) another);
  }

  private boolean equalTo(ImmutableSocialConnection another) {
    return emailAddress.equals(another.emailAddress);
  }

  /**
   * Computes a hash code from attributes: {@code emailAddress}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + emailAddress.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code SocialConnection} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "SocialConnection{"
        + "emailAddress=" + emailAddress
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link SocialConnection} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable SocialConnection instance
   */
  public static ImmutableSocialConnection copyOf(SocialConnection instance) {
    if (instance instanceof ImmutableSocialConnection) {
      return (ImmutableSocialConnection) instance;
    }
    return ImmutableSocialConnection.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableSocialConnection ImmutableSocialConnection}.
   * @return A new ImmutableSocialConnection builder
   */
  public static ImmutableSocialConnection.Builder builder() {
    return new ImmutableSocialConnection.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableSocialConnection ImmutableSocialConnection}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  static final class Builder {
    private static final long INIT_BIT_EMAIL_ADDRESS = 0x1L;
    private long initBits = 0x1L;

    private String emailAddress;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code SocialConnection} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(SocialConnection instance) {
      Objects.requireNonNull(instance, "instance");
      emailAddress(instance.emailAddress());
      return this;
    }

    /**
     * Initializes the value for the {@link SocialConnection#emailAddress() emailAddress} attribute.
     * @param emailAddress The value for emailAddress 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder emailAddress(String emailAddress) {
      this.emailAddress = Objects.requireNonNull(emailAddress, "emailAddress");
      initBits &= ~INIT_BIT_EMAIL_ADDRESS;
      return this;
    }

    /**
     * Builds a new {@link ImmutableSocialConnection ImmutableSocialConnection}.
     * @return An immutable instance of SocialConnection
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableSocialConnection build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableSocialConnection(emailAddress);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_EMAIL_ADDRESS) != 0) attributes.add("emailAddress");
      return "Cannot build SocialConnection, some of required attributes are not set " + attributes;
    }
  }
}
